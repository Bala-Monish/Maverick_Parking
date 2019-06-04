<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<title>User Home</title>
</head>
<body>
<div align="center">
<h1 align = "center">Maverick Parking</h1>
<h2 align = "center" >User Home Page</h2>
</div>
<form action="LogoutController" method="post">
<button type="submit" class="btn btn-primary" style="position:fixed;right:10px;top:5px;" name="btnLogout">Logout</button>
</form>

<div class="container">
<div class = "jumbotron">
<h4 align="center"  w-50>Search for Parking Spots</h4>
<form action="UserSearchController" method="post">
<div class="form-group " align="center">
    <label for="startTimeHr">Start Time (HH:mm)</label><br>
    <select class="form-control w-25 d-inline-block" name="startTimeHr">
 
      <option>01</option>
      <option>02</option>
      <option>03</option>
      <option>04</option>
      <option>05</option>
      <option>06</option>
      <option>07</option>
      <option>08</option>
      <option>09</option>
      <option>10</option>
      <option>11</option>
      <option>12</option>
      <option>13</option>
      <option>14</option>
      <option>15</option>
      <option>16</option>
      <option>17</option>
      <option>18</option>
      <option>19</option>
      <option>20</option>
      <option>21</option>
      <option>22</option>
      <option>23</option>
      <option>24</option>
      
    </select>
    
   :
    <select class="form-control w-25 d-inline-block" name="startTimeMin">
      <option>00</option>
      <option>01</option>
      <option>02</option>
      <option>03</option>
      <option>04</option>
      <option>05</option>
      <option>06</option>
      <option>07</option>
      <option>08</option>
      <option>09</option>
      <option>10</option>
      <option>11</option>
      <option>12</option>
      <option>13</option>
      <option>14</option>
      <option>15</option>
      <option>16</option>
      <option>17</option>
      <option>18</option>
      <option>19</option>
      <option>20</option>
      <option>21</option>
      <option>22</option>
      <option>23</option>
      <option>24</option>
      <option>25</option>
      <option>26</option>
      <option>27</option>
      <option>28</option>
      <option>29</option>
      <option>30</option>
      <option>31</option>
      <option>32</option>
      <option>33</option>
      <option>34</option>
      <option>35</option>
      <option>36</option>
      <option>37</option>
      <option>38</option>
      <option>39</option>
      <option>40</option>
      <option>41</option>
      <option>42</option>
      <option>43</option>
      <option>44</option>
      <option>45</option>
      <option>46</option>
      <option>47</option>
      <option>48</option>
      <option>49</option>
      <option>50</option>
      <option>51</option>
      <option>52</option>
      <option>53</option>
      <option>54</option>
      <option>55</option>
      <option>56</option>
      <option>57</option>
      <option>58</option>
      <option>59</option>
      </select>
      
  </div>
  <div class="form-group " align="center">
    <label for="duration">Duration(Minutes, max:180)</label><br>
    <select class="form-control w-25 d-inline-block" name="duration">
    <option>15</option>
    <option>30</option>
    <option>45</option>
    <option>60</option>
    <option>75</option>
    <option>90</option>
    <option>105</option>
    <option>120</option>
    <option>135</option>
    <option>150</option>
    <option>165</option>
    <option>180</option>
    </select>
    </div>
     <div class="form-group " align="center">
    <label for="duration">Parking permit Type</label>
    <select class="form-control w-25 d-inline-block" name="permitType">
    <option>Basic</option>
    <option>Midrange</option>
    <option>Premium</option>
    <option>Access</option>
    </select>
    </div>
    
    <div align="center"> 
    <input name="errMsgTimeCompare" value="<c:out value='${userrorMsgs.errMsgTimeCompare}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">   
    <button type="submit"  class="btn btn-primary" name="btnSearch">Search Parking Spots</button>
    </div>
    
    
  
</form>
</div>
</div>
<div align = "center">
<a href="createProfile.jsp">Create Profile</a>
<a href="ViewProfileController">View User Profile</a>
<a href = "PopulateUpdateProfileController">Update Profile</a>
<a href = "ViewReservationController">View Reservation</a>
<a href = "AccountStatusController">View Account Status</a>
<br>
<a href = "ViewViolationController">View Violations</a>
</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<title>User Home</title>
</head>
<body>
<div align="center">
<h1 align = "center">Maverick Parking</h1>
<h2 align = "center" >User Home Page</h2>
</div>
<form action="LogoutController" method="post">
<button type="submit" class="btn btn-primary" style="position:fixed;right:10px;top:5px;" name="btnLogout">Logout</button>
</form>

<div class="container">
<div class = "jumbotron">
<h4 align="center"  w-50>Search for Parking Spots</h4>
<form action="UserSearchController" method="post">
<div class="form-group " align="center">
    <label for="startTimeHr">Start Time (HH:mm)</label><br>
    <select class="form-control w-25 d-inline-block" name="startTimeHr">
 
      <option>01</option>
      <option>02</option>
      <option>03</option>
      <option>04</option>
      <option>05</option>
      <option>06</option>
      <option>07</option>
      <option>08</option>
      <option>09</option>
      <option>10</option>
      <option>11</option>
      <option>12</option>
      <option>13</option>
      <option>14</option>
      <option>15</option>
      <option>16</option>
      <option>17</option>
      <option>18</option>
      <option>19</option>
      <option>20</option>
      <option>21</option>
      <option>22</option>
      <option>23</option>
      <option>24</option>
      
    </select>
    
   :
    <select class="form-control w-25 d-inline-block" name="startTimeMin">
      <option>00</option>
      <option>01</option>
      <option>02</option>
      <option>03</option>
      <option>04</option>
      <option>05</option>
      <option>06</option>
      <option>07</option>
      <option>08</option>
      <option>09</option>
      <option>10</option>
      <option>11</option>
      <option>12</option>
      <option>13</option>
      <option>14</option>
      <option>15</option>
      <option>16</option>
      <option>17</option>
      <option>18</option>
      <option>19</option>
      <option>20</option>
      <option>21</option>
      <option>22</option>
      <option>23</option>
      <option>24</option>
      <option>25</option>
      <option>26</option>
      <option>27</option>
      <option>28</option>
      <option>29</option>
      <option>30</option>
      <option>31</option>
      <option>32</option>
      <option>33</option>
      <option>34</option>
      <option>35</option>
      <option>36</option>
      <option>37</option>
      <option>38</option>
      <option>39</option>
      <option>40</option>
      <option>41</option>
      <option>42</option>
      <option>43</option>
      <option>44</option>
      <option>45</option>
      <option>46</option>
      <option>47</option>
      <option>48</option>
      <option>49</option>
      <option>50</option>
      <option>51</option>
      <option>52</option>
      <option>53</option>
      <option>54</option>
      <option>55</option>
      <option>56</option>
      <option>57</option>
      <option>58</option>
      <option>59</option>
      </select>
      
  </div>
  <div class="form-group " align="center">
    <label for="duration">Duration(Minutes, max:180)</label><br>
    <select class="form-control w-25 d-inline-block" name="duration">
    <option>15</option>
    <option>30</option>
    <option>45</option>
    <option>60</option>
    <option>75</option>
    <option>90</option>
    <option>105</option>
    <option>120</option>
    <option>135</option>
    <option>150</option>
    <option>165</option>
    <option>180</option>
    </select>
    </div>
     <div class="form-group " align="center">
    <label for="duration">Parking permit Type</label>
    <select class="form-control w-25 d-inline-block" name="permitType">
    <option>Basic</option>
    <option>Midrange</option>
    <option>Premium</option>
    <option>Access</option>
    </select>
    </div>
    <div align="center">    
    <button type="submit"  class="btn btn-primary" name="btnSearch">Search Parking Spots</button>
    </div>
    
    
  
</form>
</div>
</div>
</body>
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
</html>