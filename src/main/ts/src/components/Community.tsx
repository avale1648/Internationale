import React from "react";
import ApiUrls from "../ApiUrls";
import styled from "styled-components";

interface CommunityProps {
    id:number;
    name: string;
    mature: boolean;
    rating: number;
}

const Community = () => {
    const [communityData, setcommunityData] = React.useState<CommunityProps[]>();
    
    React.useEffect(() => {fetchUserApi()}, []);

    const fetchUserApi = async () => {
        try {
            const response = await fetch(ApiUrls.Communities);
            const data = await response.json();
           
            setcommunityData(data);
            console.log(data);
        } catch(e) {
            console.error('Error', e);
        }
    };

    return (
        <UserWrapper>
            {communityData && communityData.length > 0 && (
                <h2>Communities</h2>
            )}
            {communityData && communityData.map(community => 
                <div key={community.id}>
                    Name: {community.name}, Mature: {community.mature}, Rating: {community.rating}
                </div>
            )}
        </UserWrapper>
    );
}

export default Community;

const UserWrapper = styled.div``;