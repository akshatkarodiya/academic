package com.iiitb.academic.Controller;

import com.iiitb.academic.Bean.Employee;
import com.iiitb.academic.DAO.DAOImplementation.EmployeeDAOImpl;
import com.iiitb.academic.HelloApplication;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("faculty")
public class EmployeeController extends HelloApplication {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee) {
        Employee employee1 = employeeDAO.login(employee);
        if(employee1 == null)
            return Response.status(401).build();
        else
            return  Response.ok().entity(employee1).build();
    }
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_faculty(Employee employee) {

        if(employeeDAO.addEmployee(employee))
            return Response.status(200).entity("Sucessfully added Employee").build();

        else
            return Response.status(400).entity("Failure while adding Employee").build();
    }

}
