package cn.edu.shu.society.rest;


import cn.edu.shu.society.request.AuthenticateRequest;
import cn.edu.shu.society.response.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authenticate")
public class AuthenticateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticateController.class);

    @RequestMapping(value = "/invoke", method = RequestMethod.POST)
    public ResultResponse authenticate(@RequestBody AuthenticateRequest authenticateRequest) {
        return new ResultResponse();
    }

}
