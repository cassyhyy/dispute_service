package com.srtp.dispute.utils;

import com.srtp.dispute.model.DisputeBean;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaseReader {
    final private SnowFlakeIdGenerator idGenerator;

    public CaseReader() {
        idGenerator = new SnowFlakeIdGenerator(1, 1);
    }

    // 医患纠纷excel文件读取处理
    public List<DisputeBean> readDisputeExcel() {
        Workbook readwb = null;
        ArrayList<DisputeBean> documentList = new ArrayList<DisputeBean>();
        String regEx1 = "(.*)与(.*)医疗纠纷";
        Pattern p = Pattern.compile(regEx1);

        //读取EXCEL文件获取文书
        InputStream instream = null;

        try {
            instream = this.getClass().getResourceAsStream("/case/6月人民调解（医疗纠纷）.xls");
//            instream = new FileInputStream("/case/6月人民调解（医疗纠纷）.xls");
            readwb = Workbook.getWorkbook(instream);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }


        //获取第一张Sheet表
        Sheet readsheet = readwb.getSheet(0);
        //获取Sheet表中所包含的总列数
        int rsColumns = readsheet.getColumns();
        //获取Sheet表中所包含的总行数
        int rsRows = readsheet.getRows();

        int j = 0;
        Cell cell = null;
        String s = null;

        IndexResponse response = null;

        //获取指定单元格的对象引用
        for (int i = 1; i < rsRows; i++) {
            DisputeBean d = new DisputeBean("0", "", "", "", "", "0", "0", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

            //设置id
            long id = idGenerator.nextId();
            d.setId(id);

            //设置编号
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            //先判断s是否为空，为空则将s置为缺省值
            if (s == null || s.isEmpty())
                s = "0";
            d.setDisputeNO(s);
            s = null;
            j++;

            //设置区划
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDistrict(s);
            s = null;
            j++;

            //设置纠纷名称
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDisputeName(s);
            s = null;
            j++;

            //设置案情评估
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setEvaluation(s);
            s = null;
            j++;

            //设置激烈程度
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setFierceDegree(s);
            s = null;
            j++;

            //设置涉及人数
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "0";
            d.setDisputePerson(s);
            s = null;
            j++;

            //设置涉及纠纷金额
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "0.0";
            d.setCompensation(s);
            s = null;
            j++;

            //设置纠纷等级
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDisputeDegree(s);
            s = null;
            j++;

            //设置受理时间
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "19970701";
            else {
                //设置时间格式：20170701
                String[] temp = s.split("-");
                String year = "20" + temp[0];
                String month = "", day = "";
                if (temp[1].length() < 2)
                    month = "0" + temp[1];
                else
                    month = temp[1];
                if (temp[2].length() < 2)
                    day = "0" + temp[2];
                else
                    day = temp[2];
                s = year + month + day;
            }
            d.setAcceptDate(s);
            s = null;
            j++;

            //设置案件来源
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDisputeOrigin(s);
            s = null;
            j++;

            //设置纠纷类型
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDisputeType(s);
            s = null;
            j++;

            //设置纠纷区域
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDisputeArea(s);
            s = null;
            j++;

            //设置发生地点
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDisputeLocation(s);
            s = null;
            j++;

            //设置简要情况
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setBriefInfo(s);
            s = null;
            j++;

            //设置调解结果
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setDisputeResolution(s);
            s = null;
            j++;

            //设置调解成功时间
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setResolutionDate(s);
            s = null;
            j++;

            //设置责任单位
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setInstitution(s);
            s = null;
            j++;

            //设置调解员
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setStaffName(s);
            s = null;
            j++;

            //设置达成协议内容
            cell = readsheet.getCell(j, i);
            s = cell.getContents();
            if (s == null || s.isEmpty())
                s = "";
            d.setAgreement(s);
            s = null;

            //设置标签
            d.setDisputeTag("暂无");

            //j重新置0
            j = 0;
            //设置当事人姓名、身份证号、涉事医院名称、科室名称
            cell = readsheet.getCell(2, i);
            String content = cell.getContents();
            //解析出当事人姓名和医院名称
            if ((content != null) && (!content.isEmpty())) {
                Matcher m = p.matcher(content);
                if (m.find()) {
                    if (m.group(1).contains("医院")) {
                        d.setHospitalName(m.group(1));
                        d.setPersonName(m.group(2));
                    } else {
                        d.setHospitalName(m.group(2));
                        d.setPersonName(m.group(1));
                    }
                }
            }
            documentList.add(d);
        }
//        System.out.println(documentList.get(0).getAbstract());
        return documentList;
    }
}
