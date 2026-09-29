
package G2.WebsiteBanDT.controllers;

import G2.WebsiteBanDT.models.User;
import G2.WebsiteBanDT.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User newUser) {
        Map<String, Object> response = new HashMap<>();
        
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            response.put("status", "error");
            response.put("message", "Tên đăng nhập đã tồn tại!");
            return response;
        }

        newUser.setRole("CUSTOMER");
        userRepository.save(newUser);

        response.put("status", "success");
        response.put("message", "Đăng ký thành công!");
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User loginRequest) {
        Map<String, Object> response = new HashMap<>();
        
        User user = userRepository.findByUsername(loginRequest.getUsername());
        
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            response.put("status", "success");
            response.put("message", "Đăng nhập thành công!");
            response.put("role", user.getRole()); 
            response.put("userId", user.getId());
        } else {
            response.put("status", "error");
            response.put("message", "Sai tài khoản hoặc mật khẩu!");
        }
        return response;
    }
}
