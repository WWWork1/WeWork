import React, { useState } from 'react';
import Button from '@mui/material/Button';
const Menu = () => {
    const [isShowing, setIsShowing] = useState(true);

    const toggleVisibility = () => {
        setIsShowing((prevIsShowing) => !prevIsShowing);
    };
    return (
        <div>
            <Button onClick={toggleVisibility}>
                {isShowing ? 'Hide Items' : 'Show Items'}
            </Button>

            {isShowing && (
                <div>
                    <Button variant="contained" color="secondary" size="large" style={{
                        borderRadius: '8px', width: "100%", marginTop: "55px",
                        fontWeight: 'bold',
                    }} > Click me</Button>
                    <Button variant="contained" color="primary" size="large" style={{
                        borderRadius: '8px', width: "100%", marginTop: "45px",
                        fontWeight: 'bold',
                    }} > Click me</Button>
                    <Button variant="contained" color="primary" size="large" style={{
                        borderRadius: '8px', width: "100%", marginTop: "45px",
                        fontWeight: 'bold',
                    }} > Click me</Button>
                    <Button variant="contained" color="primary" size="large" style={{
                        borderRadius: '8px', width: "100%", marginTop: "45px",
                        fontWeight: 'bold',
                    }} > Click me</Button>
                    <Button variant="contained" color="primary" size="large" style={{
                        borderRadius: '8px', width: "100%", marginTop: "45px",
                        fontWeight: 'bold',
                    }} > Click me</Button>
                    <Button variant="contained" color="primary" size="large" style={{
                        borderRadius: '8px', width: "100%", marginTop: "45px",
                        fontWeight: 'bold',
                    }} > Click me</Button>
                </div>
            )}

        </div>
    );
};
export default Menu;