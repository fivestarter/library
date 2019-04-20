package ru.startsev.library;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.PropertySourcedMapping;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.web.Swagger2Controller;

import javax.servlet.http.HttpServletRequest;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static springfox.documentation.swagger.common.HostNameProvider.componentsFrom;

@Controller
@ApiIgnore
@RequestMapping("/v1/announcements")
public class Swagger2ControllerProxy {

    private static final String HAL_MEDIA_TYPE = "application/hal+json";

    private Swagger2Controller swagger2Controller;


    @Autowired
    public Swagger2ControllerProxy(Swagger2Controller swagger2Controller) {
        this.swagger2Controller = swagger2Controller;
    }

    @RequestMapping(
            value = "/api-docs",
            method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE })
    @ResponseBody
    public ResponseEntity<Json> getDocumentation(
            @RequestParam(value = "group", required = false) String swaggerGroup,
            HttpServletRequest servletRequest) {

        return swagger2Controller.getDocumentation(swaggerGroup, servletRequest);
    }


}
