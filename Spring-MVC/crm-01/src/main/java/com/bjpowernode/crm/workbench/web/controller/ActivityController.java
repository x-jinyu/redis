package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.domain.ActivityRemark;
import com.bjpowernode.crm.workbench.service.ActivityRemarkService;
import com.bjpowernode.crm.workbench.service.ActivityServie;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * 王金宇
 * 2020/12/28 0028
 */
@Controller
public class ActivityController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivityServie activityService;

    @Autowired
    private ActivityRemarkService activityRemarkService;

    //跳转至市场活动首页
    @RequestMapping("/workbench/activity/index.do")
    public String index(Model model) {
        List<User> userList = userService.queryAllUsers();
        model.addAttribute("userList", userList);
        return "/workbench/activity/index";
    }

    //在“创建”模态窗口绑定保存按钮
    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    @ResponseBody
    public Object saveCreateActivity(Activity activity, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));
        activity.setCreateBy(user.getId());
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityService.saveCreateActivity(activity);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统错误，稍后重新尝试");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统错误，稍后重新尝试");
        }
        return returnObject;
    }

    //分页查询
    @RequestMapping("/workbench/activity/queryActivityForPageByCondition.do")
    @ResponseBody
    public Object queryActivityForPageByCondition(int pageNo, int pageSize, String name, String owner, String startDate, String endDate) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("beginNo", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        List<Activity> activityList = activityService.queryActivityForPageByCondition(map);
        long totalRows = activityService.queryCountofActivityByCondition(map);

        //生成返回信息
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("activityList", activityList);
        retMap.put("totalRows", totalRows);
        return retMap;
    }

    @RequestMapping("/workbench/activity/editActivity.do")
    @ResponseBody
    public Object editActivity(String id) {
        Activity activity = activityService.queryActivityById(id);
        return activity;
    }

    @RequestMapping("/workbench/activity/saveEditActivity.do")
    @ResponseBody
    public Object saveEditActivity(HttpSession session, Activity activity) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        activity.setEditBy(user.getId());
        activity.setEditTime(DateUtils.formatDateTime(new Date()));
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityService.saveEditActivity(activity);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统错误，稍后重新尝试");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统错误，稍后重新尝试");
        }
        return returnObject;
    }

    //详情
    @RequestMapping("/workbench/activity/detailActivity.do")
    public String detailActivity(String id,Model model){
        //调用service层方法，查询数据
        Activity activity=activityService.queryActivityForDetailById(id);
        List<ActivityRemark> remarkList=activityRemarkService.queryActivityRemarkForDetailByActivityId(id);
        //把数据保存到request中
        model.addAttribute("activity",activity);
        model.addAttribute("remarkList",remarkList);
        //请求转发
        return "workbench/activity/detail";
    }

    //删除选中的市场活动
    @RequestMapping("/workbench/activity/deleteActivityByIds.do")
    @ResponseBody
    public Object deleteActivityByIds(String[] id) {
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityService.deleteActivityByIds(id);
            if (ret > 0) {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统错误，稍后重新尝试");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统错误，稍后重新尝试");
        }
        return returnObject;
    }

    //批量导出
    @RequestMapping("/workbench/activity/exportAllActivity.do")
    public void exportAllActivity(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //讲数据库所有的市场活动信息全部提取出来
        List<Activity> activityList = activityService.queryAllActivityForDetail();
        //创建excel文件对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //页
        HSSFSheet sheet = wb.createSheet("市场活动表");
        //行
        HSSFRow row = sheet.createRow(0);
        //列
        HSSFCell cell = row.createCell(0);
        //为第一行创建标题信息
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("所有者");
        cell = row.createCell(2);
        cell.setCellValue("名称");
        cell = row.createCell(3);
        cell.setCellValue("开始日期");
        cell = row.createCell(4);
        cell.setCellValue("结束日期");
        cell = row.createCell(5);
        cell.setCellValue("成本");
        cell = row.createCell(6);
        cell.setCellValue("描述");
        cell = row.createCell(7);
        cell.setCellValue("创建者");
        cell = row.createCell(8);
        cell.setCellValue("创建时间");
        cell = row.createCell(9);
        cell.setCellValue("修改者");
        cell = row.createCell(10);
        cell.setCellValue("修改时间");

        //创建样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        //填充表信息
        if (activityList != null) {
            Activity activity = null;
            for (int i = 0; i < activityList.size(); i++) {
                //在数据库中获取每条数据
                activity = activityList.get(i);

                row = sheet.createRow(i + 1);

                cell = row.createCell(0);
                cell.setCellValue(activity.getId());
                cell = row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell = row.createCell(2);
                cell.setCellValue(activity.getName());
                cell = row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell = row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell = row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell = row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell = row.createCell(7);
                cell.setCellValue(activity.getCreateBy());
                cell = row.createCell(8);
                cell.setCellValue(activity.getCreateTime());
                cell = row.createCell(9);
                cell.setCellValue(activity.getEditBy());
                cell = row.createCell(10);
                cell.setCellValue(activity.getEditTime());
            }
        }
        //设置响应类型
        response.setContentType("application/actet-strean;charset=UTF-8");
        //使用请求对象调用请求头内浏览器对象
        String browser = request.getHeader("User-Agent");

        //兼容多浏览器
        String fileName = URLEncoder.encode("市场活动列表", "UTf-8");
        if (browser.contains("edge")) {
            fileName = new String("市场活动列表".getBytes("UTF-8"), "UTF-8");
            //fileName = URLEncoder.encode("市场活动列表","UTF-8");
        }

        response.addHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");

        //使用输出流进行输出
        OutputStream os = response.getOutputStream();
        wb.write(os);
        os.flush();
        wb.close();
    }

    //选择导出
    @RequestMapping("/workbench/activity/exportActivitySelective.do")
    public void exportActivitySelective(String[] id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //提取数据库数据
        List<Activity> activityList = activityService.queryActivityForDetailByIds(id);

        //根据查询结果，生成excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("市场活动列表");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("所有者");
        cell = row.createCell(2);
        cell.setCellValue("名称");
        cell = row.createCell(3);
        cell.setCellValue("开始日期");
        cell = row.createCell(4);
        cell.setCellValue("结束日期");
        cell = row.createCell(5);
        cell.setCellValue("成本");
        cell = row.createCell(6);
        cell.setCellValue("描述");
        cell = row.createCell(7);
        cell.setCellValue("创建者");
        cell = row.createCell(8);
        cell.setCellValue("创建时间");
        cell = row.createCell(9);
        cell.setCellValue("修改者");
        cell = row.createCell(10);
        cell.setCellValue("修改时间");

        //创建HSSFCellStyle对象，对应样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        //5.遍历activityList，显示数据行
        if (activityList != null) {
            Activity activity = null;
            for (int i = 0; i < activityList.size(); i++) {
                activity = activityList.get(i);//获取每一条数据

                row = sheet.createRow(i + 1);//创建一行

                cell = row.createCell(0);//column：列的编号,从0开始，0表示第一列，1表示第二列，....
                cell.setCellValue(activity.getId());
                cell = row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell = row.createCell(2);
                cell.setCellValue(activity.getName());
                cell = row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell = row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell = row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell = row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell = row.createCell(7);
                cell.setCellValue(activity.getCreateBy());
                cell = row.createCell(8);
                cell.setCellValue(activity.getCreateTime());
                cell = row.createCell(9);
                cell.setCellValue(activity.getEditBy());
                cell = row.createCell(10);
                cell.setCellValue(activity.getEditTime());
            }
        }

        //设置响应类型
        response.setContentType("application/actet-strean;charset=UTF-8");
        //在请求头中有一个User-Agent
        String browser = request.getHeader("User-Agent");
        //火狐ISO8859-1
        String fileName = URLEncoder.encode("市场活动列表", "UTf-8");
        if (browser.contains("firefox")) {
            fileName = new String("市场活动列表".getBytes("UTF-8"), "ISO8859-1");
        }

        response.addHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");

        //使用输出流进行输出
        OutputStream os = response.getOutputStream();
        wb.write(os);
        os.flush();
        wb.close();
    }

    //上传列表数据
    @RequestMapping("/workbench/activity/importActivity.do")
    @ResponseBody
    public Object importActivity(MultipartFile activityFile, String username, HttpSession session) throws Exception {
        ReturnObject returnObject = new ReturnObject();
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        //返回结果
        Map<String, Object> retMap = new HashMap<>();
        //解析excel文件，获取每一个Activity，将所有Activity封装再一个集合中
        List<Activity> activityList = new ArrayList<>();
        //获取上传的文件
        InputStream is = activityFile.getInputStream();
        //创建工作簿
        HSSFWorkbook wb = new HSSFWorkbook(is);
        //获取第一页
        HSSFSheet sheet = wb.getSheetAt(0);
        //设置对象，行，列，活动
        HSSFRow row = null;
        HSSFCell cell = null;
        Activity activity = null;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            activity = new Activity();
            //Activity数据来自两部分,一部分是动态的,不在excel中,程序员给.另一部分固定的,从excel对应的行中获取
            activity.setId(UUIDUtils.getUUID());
            activity.setOwner(user.getId());
            activity.setCreateBy(user.getId());
            activity.setCreateTime(DateUtils.formatDateTime(new Date()));
            //将用户上传的excel的模板文件进行解析,将每一个cell中的数据放到activity
            for (int j = 0; j < row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                String cellValue=getCellValue(cell);
                if(j==0){
                    activity.setName(cellValue);
                }else if(j==1){
                    activity.setStartDate(cellValue);
                }else if(j==2){
                    activity.setEndDate(cellValue);
                }else if(j==3){
                    activity.setCost(cellValue);
                }else if(j==4){
                    activity.setDescription(cellValue);
                }
            }
            activityList.add(activity);
        }

        //调用业务层处理
        int ret = activityService.saveCreateActivityByList(activityList);

        //保存前端需要的结果
        retMap.put("code",Contants.RETURN_OBJECT_CODE_SUCCESS);
        retMap.put("count",ret);

        return retMap;
    }

    public static String getCellValue(HSSFCell cell) {
        String ret = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                ret = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                ret = cell.getBooleanCellValue() + "";
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                ret = cell.getNumericCellValue() + "";
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                ret = cell.getCellFormula();
                break;
            default:
                ret = "";
        }
        return ret;
    }
}