import UserProps from "./UserProps";

interface CommunityProps {
    
    id: number;
    founder: UserProps;
    name: string;
    mature: boolean;
    rating: number;
    cakedate: Date;
    description: string;
    pfp: string;
    banner: string;
}

export default CommunityProps;