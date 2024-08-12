import CommunityProps from "./CommunityProps";
import UserProps from "./UserProps";

interface PostProps {
    id: number;
    user: UserProps;
    community: CommunityProps;
    parentPost: PostProps;
    title: string;
    text: string;
    postDate: Date;
    rating: number;
    file: string;
}

export default PostProps;