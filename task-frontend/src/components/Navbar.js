import React from "react";
import { Link } from "react-router-dom";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
//import AddUser from "./components/users/AddUser";
//import Users from "./users/Users";
const Navbar = () => {
  return (
    <div className="navbar">
      <div className="logo">Form System</div>
      <div className="nav-items">
        {/* <Link className="btn btn-outline-light" to="/">
          Home
        </Link>
        <Link className="btn btn-outline-light" to="/mentors">
          Mentors
        </Link>
        <Link className="btn btn-outline-light" to="/tasks">
          Tasks
        </Link> */}
        {/* <Routes>
          <Route>
          <Route  exact path="/" component={Home}/>
          <Route  path="/users" component={Users}/>
          <Route  path="/courses" component={Courses}/>
          <Route  path="/tasks" component={Task}/>
         </Route>
        </Routes> */}
      </div>
    </div>
  );
};

export default Navbar;
