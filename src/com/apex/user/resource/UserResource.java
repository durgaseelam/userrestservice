package com.apex.user.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apex.user.service.UserService;

import com.apex.user.vo.UserVO;

@Path("/v2/user")
public class UserResource {
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void addUser(UserVO UserVO) {
		UserService userService=new UserService();
		System.out.println("UserResource.addUser():Start()");
		userService.addUser(UserVO);
		System.out.println("UserResource.addUser():End()");
	}

	@GET
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public UserVO getUser(@PathParam("userid") String id) {
		UserService userService=new UserService();
		System.out.println("UserResource.getUser():Start()");
		UserVO userVO=userService.getUser(Integer.parseInt(id));
		System.out.println("UserResource.getUser():End()");
		return userVO;
	}
	
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void updateUser(UserVO userVO) {
		UserService userService=new UserService();
		System.out.println("UserResource.updateUser():Start()");
		userService.updateUser(userVO);
		System.out.println("UserResource.updateUser():End()");
	}
	
	@DELETE	
	@Path("/{userid}")
	public void deleteUser(@PathParam("userid") String id) {
		UserService userService=new UserService();
		System.out.println("UserResource.updateUser():Start()");
		System.out.println(" Integer parse int "+Integer.parseInt(id));
		userService.deleteUser(Integer.parseInt(id));
		System.out.println("UserResource.updateUser():End()");
		
	}
	
	
	}


