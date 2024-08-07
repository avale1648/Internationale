import React from "react";
import ApiUrls from "../ApiUrls";
import styled from "styled-components";

interface UserProps {
    id:number;
    name: string;
    role: string;
    email: string;
}

const User = () => {
    const [userData, setUserData] = React.useState<UserProps[]>();
    
    React.useEffect(() => {fetchUserApi()}, []);

    const fetchUserApi = async () => {
        try {
            const response = await fetch(ApiUrls.Users);
            const data = await response.json();
           
            setUserData(data);
            console.log(data);
        } catch(e) {
            console.error('Error', e);
        }
    };

    return (
        <UserWrapper>
            {userData && userData.length > 0 && (
                <h2>Users</h2>
            )}
            {userData && userData.map(user => 
                <div key={user.id}>
                    Name: {user.name}, Role: {user.role}, Email: {user.email}
                </div>
            )}
        </UserWrapper>
    );
}

export default User;

const UserWrapper = styled.div``;