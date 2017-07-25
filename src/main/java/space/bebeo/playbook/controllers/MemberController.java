package space.bebeo.playbook.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.bebeo.playbook.context.MemberContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    @RequestMapping(value = "/hello", headers = "Accept=application/json")
    public String get(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        List<MemberContext> list = new ArrayList<MemberContext>();

        MemberContext context = new MemberContext();
        context.setAge(1);
        context.setName("zzzz");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(context);

    }

}
