import React from "react";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';

const Header = () => {
    return (
        <AppBar position="static">
        <Toolbar>
          {/* Logo */}
          <img
            src="link" // Replace with the path to your logo image
            alt="img"
            style={{ width: '40px', marginRight: '10px' }} // Adjust the width and spacing as needed
          />
          
         
          <Typography variant="h6" component="div">
            We Work
          </Typography>
  
          {/* Spacer */}
          <div style={{ flexGrow: 1 }} />
  
          {/* Login and Register Buttons */}
          <Button color="inherit">Login</Button>
          <Button color="inherit">Register</Button>
        </Toolbar>
      </AppBar>
    );
};
export default Header;