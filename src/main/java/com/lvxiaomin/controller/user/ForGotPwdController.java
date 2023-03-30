package com.lvxiaomin.controller.user;

import com.lvxiaomin.service.MailService;
import com.lvxiaomin.service.UserService;
import com.lvxiaomin.utils.AjaxJson;
import com.lvxiaomin.vo.CodeUpdatePwdVo;
import com.lvxiaomin.vo.SendCodeVo;
import com.lvxiaomin.vo.UpdateUserPwd;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**用户忘记密码
 * @Author: Ming
 * @Date: 2023/3/28 9:46
 */
@RestController
@RequestMapping("/forgot")
public class ForGotPwdController {

    @Resource
    private MailService mailService;

    @Resource
    private UserService userService;


    /**
     * 发送验证码
     * @param sendCodeVo
     * @return ajaxJson
     */
    @GetMapping("/sendCode")
    public AjaxJson sendCodeService(@Valid SendCodeVo sendCodeVo) {
        AjaxJson ajaxJson = mailService.sendCode(sendCodeVo.getUserEmail());
        return ajaxJson;
    }



    @PostMapping("/update-verify")
    public AjaxJson updateUserVerify(@RequestBody @Valid CodeUpdatePwdVo codeUpdatePwdVo){
        AjaxJson ajaxJson = userService.forgetUpdateSecret(codeUpdatePwdVo);
        return ajaxJson;
    }

    @PostMapping("/update-pwd")
    public AjaxJson updateUserPwd(@RequestBody @Valid UpdateUserPwd updateUserPwd){
        AjaxJson ajaxJson = userService.updateUserPwd(updateUserPwd);
        return ajaxJson;
    }
}
