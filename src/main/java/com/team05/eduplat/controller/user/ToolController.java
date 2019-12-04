package com.team05.eduplat.controller.user;

import com.team05.eduplat.entity.vo.user.EmailVo;
import com.team05.eduplat.utils.Result.ResultEnum;
import com.team05.eduplat.utils.Result.ResultHelper;
import com.team05.eduplat.utils.Result.ResultMessage;
import com.team05.eduplat.utils.user.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;

/**
 * @program: eduplat
 * @description: TODO
 * @author: chen wenliang
 * @Date 2019/11/25
 **/
@RestController
public class ToolController {
    @ApiOperation("发邮箱验证码")
    @PostMapping("/sendMail")
    public ResultMessage sendMail(@RequestBody String mail, HttpServletRequest request,HttpServletResponse response) throws Exception{
        int code=new Random().nextInt(9999);
        DecimalFormat format=new DecimalFormat("0000");
        request.getSession().setAttribute("emailCode",format.format(code));
        EmailVo emailVo = new EmailVo();
        emailVo.setUserName("1753728599@qq.com");
        emailVo.setPassword("eycoymjwrekybgga");
        emailVo.setHost("smtp.qq.com");
        emailVo.setPort(25);
        emailVo.setFromAddress("1753728599@qq.com");
        emailVo.setToAddress(mail.replace("\"","").trim());
        emailVo.setSubject("教育平台EduPlat的邮箱验证码");
        emailVo.setContext("本次获取的验证码为："+code+",非本人操作，请忽略！");
        if (UserUtil.emailSend(emailVo)){
            System.out.println("已发送");
            return ResultHelper.result(ResultEnum.EMAIL_SEND_SUCCESS).setMsg("已发送");
        }else {
            //不联网等其他异常
            return ResultHelper.result(ResultEnum.EMAIL_SEND_FAIL).setMsg("发送失败");
        }
    }
    @ApiOperation("验证输入邮箱验证码是否对")
    @PostMapping("/vEmail")
    public ResultMessage vEmail(@RequestBody String code,HttpServletRequest request) throws Exception{
        String emailCode=request.getSession().getAttribute("emailCode")+"";
        if (emailCode.equals(code.replace("\"","").trim())){
            return  ResultHelper.result(ResultEnum.SUCCESS).setMsg("验证码输入正确");
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("验证码错误");
        }
    }
    @ApiOperation("获取图片验证码")
    @GetMapping("/getVerificationCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object>map=UserUtil.generateCodeAndPic();
        BufferedImage bufferedImage= (BufferedImage) map.get("codeImg");
        String code= map.get("code").toString();
        request.getSession().setAttribute("vCode",code);
        try {
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            ImageIO.write(bufferedImage,"png",os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @ApiOperation("验证输入图片验证码是否对")
    @PostMapping("/vCode")
    public ResultMessage vCode(@RequestBody String code, HttpServletRequest request) throws Exception{
        String vCode=request.getSession().getAttribute("vCode")+"";
        System.out.println("vCode"+vCode);
        System.out.println("Code"+code);
        if (code==null){
            return ResultHelper.result(ResultEnum.FAIL).setMsg("验证码输入为空");
        }
        if (vCode==null){
            return ResultHelper.result(ResultEnum.FAIL).setMsg("验证码生成为空");
        }
        if (vCode.equalsIgnoreCase(code.replace("\"","").trim())){
            return  ResultHelper.result(ResultEnum.SUCCESS).setMsg("验证码输入正确");
        }else {
            return ResultHelper.result(ResultEnum.FAIL).setMsg("验证码错误");
        }
    }
}
