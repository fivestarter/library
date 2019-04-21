package ru.startsev.library.swagger;

import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger.web.*;

import java.util.List;

@Controller
@ApiIgnore
@RequestMapping("/v1/announcements/swagger-resources")
public class ApiResourceControllerProxy {

    private ApiResourceController apiResourceController;

    @Autowired
    public ApiResourceControllerProxy(ApiResourceController apiResourceController) {
        this.apiResourceController = apiResourceController;
    }

    @RequestMapping(value = "/configuration/security")
    @ResponseBody
    public ResponseEntity<SecurityConfiguration> securityConfiguration() {
        return apiResourceController.securityConfiguration();
    }

    @RequestMapping(value = "/configuration/ui")
    @ResponseBody
    public ResponseEntity<UiConfiguration> uiConfiguration() {
        return apiResourceController.uiConfiguration();
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return apiResourceController.swaggerResources();
    }
}
