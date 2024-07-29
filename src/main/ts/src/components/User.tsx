import React from "react";
import ApiUrls from "../ApiUrls";

const User = () => {
    const [user, setUser] = React.useState();
    
    React.useEffect(()=> {fetchUserApi()}, []);

    const fetchUserApi = async () => {
        try {
            const response = await fetch(ApiUrls.Users);
            const data = await response.json();
           
            setUser(data);
            console.log(data);
        } catch(e) {
            console.error('Error', e);
        }
    };

    return (
        <div>
            <h1>Users</h1>
        </div>
    );
}

export default User;