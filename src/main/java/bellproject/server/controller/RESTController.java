package bellproject.server.controller;

import bellproject.server.pojo.OrganizationEntity;
import bellproject.server.service.OfficeService;
import bellproject.server.service.OrganizationService;
import bellproject.server.service.UserService;
import bellproject.view.OfficeView;
import bellproject.view.OrganizationView;
import bellproject.view.UserView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class RESTController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @PostMapping("/api/organization/list")
    public List<OrganizationView> getOrganizations(@RequestBody OrganizationView organizationView) {
        return organizationService.findAllOrganization().stream().filter(x -> x.filter(organizationView)).collect(Collectors.toList());
    }

    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @PostMapping("/api/organization/save")
    public String saveOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.saveOrganization(organizationView);
        return "success";
    }

    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")
    @GetMapping("/api/organization/{id}")
    public OrganizationView getOrganization(@PathVariable("id") String id) {
        return organizationService.findOrganizationById(Long.parseLong(id));
    }


    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @PostMapping("/api/organization/update")
    public String updateOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.update(organizationView);
        return "success";
    }


    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "GET")
    @GetMapping("/api/office/{id}")
    public OfficeView getOffice(@PathVariable("id") String id) {
        return officeService.findOfficeById(Long.parseLong(id));
    }


    @ApiOperation(value = "saveOffice", nickname = "saveOffice", httpMethod = "POST")
    @PostMapping("/api/office/save")
    public String saveOffice(@RequestBody OfficeView officeView) {
        officeService.saveOffice(officeView);
        return "success";
    }


    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "POST")
    @PostMapping("/api/office/list")
    public List<OfficeView> getOffices(@RequestBody OfficeView officeView) {
        return officeService.findAllOffice().stream().filter(x -> x.filter(officeView)).collect(Collectors.toList());
    }

    @ApiOperation(value = "updateOffice", nickname = "updateOffice", httpMethod = "POST")
    @PostMapping("/api/office/update")
    public String updateOffice(@RequestBody OfficeView officeView) {
        officeService.update(officeView);
        return "success";
    }


    @ApiOperation(value = "getUser", nickname = "getUser", httpMethod = "GET")
    @GetMapping("/api/user/{id}")
    public UserView getUser(@PathVariable("id") String id) {
        return userService.findUserById(Long.parseLong(id));
    }


    @ApiOperation(value = "saveOffice", nickname = "saveOffice", httpMethod = "POST")
    @PostMapping("/api/user/save")
    public String saveUser(@RequestBody UserView userView) {
        userService.saveUser(userView);
        return "success";
    }


    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "POST")
    @PostMapping("/api/user/list")
    public List<UserView> getUsers(@RequestBody UserView userView) {
        return userService.findAllUsers().stream().filter(x -> x.filter(userView)).collect(Collectors.toList());
    }

    @ApiOperation(value = "updateOffice", nickname = "updateOffice", httpMethod = "POST")
    @PostMapping("/api/user/update")
    public String updateUser(@RequestBody UserView userView) {
        userService.update(userView);
        return "success";
    }


}
