<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>login.html</title>
    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
 
  </head>
  
  <body>
    <form action="/regDemo/regist" method="post" enctype="multipart/form-data">
        <table  align="center">
            <tr>
                <td>username</td>
                <td>
                    <input type="text" name="username" />
                </td>
            </tr>
            <tr>
                <td>password</td>
                <td>
                    <input type="password" name="password"/>
                </td>
            </tr>
            <tr>
                <td>sex</td>
                <td>
                    <input type="radio" name="sex" value="male" checked="checked"/>male
                    <input type="radio" name="sex" value="female"/>female
                </td>
            </tr>
            <tr>
                <td>address</td>
                <td>
                    <select name="city">
                        <option  value="beijing" selected>Beijing</option>
                        <option  value="tianjin">Tianjin</option>
                        <option  value="shanghai">Shanghai</option>
                    </select>
                    <select name="district">
                        <option value="haidian" selected>Haidian</option>
                        <option value="chaoyang">Chaoyang</option>
                        <option value="changping">Changping</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Hobby</td>
                <td>
                    <input type="checkbox" name="hobby" value="sport" checked="checked"/>sport
                    <input type="checkbox" name="hobby" value="basketball"/>basketball
                    <input type="checkbox" name="hobby" value="volleyball"/>baseball
                </td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td>
                    <input type="text" name="email" />
                </td>
            </tr>
            <tr>
                <td>phone</td>
                <td>
                    <input type="text" name="phone" />
                </td>
            </tr>
            <tr>
                <td>photo</td>
                <td>
                    <input type="file" name="upload" />
                </td>
            </tr>
            <tr>
                <td>others</td>
                <td>
                    <textarea name="others" rows="15" cols="50"></textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    
                    <input type="submit" name="tijiao" id="reg_btn" value="register"/>
                    <input type="reset" name="quxiao" id="" value="cancel"/>
                </td>
            </tr>
            <tr>
                <td></td>
            
            </tr>
        </table>
    </form> 
  </body>
</html>