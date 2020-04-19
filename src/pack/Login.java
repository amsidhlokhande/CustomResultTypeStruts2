package pack;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.brainysoftware.captcha.CaptchaUtil;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements ServletRequestAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String validateString;
	private HttpServletRequest servletRequest;
	private String hashCookieName="hashCookieName";
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getValidateString()
	{
		return validateString;
	}

	public void setValidateString(String validateString)
	{
		this.validateString = validateString;
	}

	public HttpServletRequest getServletRequest()
	{
		return servletRequest;
	}
   
	public void setServletRequest(HttpServletRequest servletRequest)
	{
		this.servletRequest = servletRequest;
	}

	public String getHashCookieName()
	{
		return hashCookieName;
	}

	public void setHashCookieName(String hashCookieName)
	{
		this.hashCookieName = hashCookieName;
	}
    
	public String execute()
	{
      HttpServletRequest request=(HttpServletRequest)servletRequest;
      Cookie cookie[]=request.getCookies();
      String hash=null;
      for(Cookie c:cookie)
      {
    	  System.out.println(c.getName());
    	  if(c.getName().equals(hashCookieName))
    	  {
    		  
    		  hash=c.getValue();
    		  System.out.println(hash);
    	  }
      }
      
      if(hash!=null && userName.equals("amsidhl") && password.equals("********") && CaptchaUtil.validate(validateString, hash))
      {
    	  return "success";
      }
      else
      {
    	  addActionError("Login failed.");
    	  return "input";
      }
	}

	
	
}
