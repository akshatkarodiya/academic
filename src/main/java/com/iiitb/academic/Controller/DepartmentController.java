package com.iiitb.academic.Controller;

import com.iiitb.academic.Bean.Department;
import com.iiitb.academic.DAO.DAOImplementation.DepartmentDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/department")
public class DepartmentController {
    DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_faculty(Department department) {

        if(departmentDAO.addDepartment(department))
            return Response.status(200).entity("Sucessfully added Department").build();

        else
            return Response.status(400).entity("Failure while adding Department").build();
    }
}
