package com.kgc.controller.fore;
import com.kgc.pojo.Address;
import com.kgc.pojo.User;
import com.kgc.service.AddressService;
import com.kgc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;//用户service
    @Resource
    AddressService addressService;//地址service
    @RequestMapping("")
    public String index(Model model) {
        return "fore/homePage";
    }

    @RequestMapping("/UserLogin")
    public String UserLogin() {
        return "fore/loginPage";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/user/UserLogin";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("addressList", addressService.addressList());
        model.addAttribute("cityList", addressService.cityList("110000"));
        model.addAttribute("districtList", addressService.districtList("110100"));
        return "fore/register";
    }

    @RequestMapping("/userDetails")
    public String userDetailsc(Model model, HttpSession session) {//绑定数据
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String substring = user.getUserAddress().substring(0, 2);
            Address address = addressService.getByUserAddress(user.getUserAddress());
            substring += "0000";//省
            model.addAttribute("addressId", substring);
            model.addAttribute("districtAddressId", address.getAddressAreaId());
            model.addAttribute("cityAddressId", address.getAddressRegionId());
            model.addAttribute("addressList", addressService.addressList());
            model.addAttribute("cityList", addressService.cityList(substring));
            model.addAttribute("districtList", addressService.districtList(addressService.cityList(substring).get(0).getAddressAreaId()));
            return "fore/userDetails";
        }
        return "redirect:/user/UserLogin";
    }

    @RequestMapping("/update")//修改用户信息
    public String update(User user,HttpSession session){
        User u1 = (User) session.getAttribute("user");
        Integer userId = u1.getUserId();
        u1=user;
        u1.setUserId(userId);
        if (userService.getUserUpdate(u1)>0){
            session.removeAttribute("user");
            session.setAttribute("user",u1);
            return "redirect:/home";
        }
        return "fore/userDetails";
    }
}
