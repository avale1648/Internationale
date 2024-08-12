import UserProps from "./UserProps";

interface MessageProps {
    id: number;
    sender: UserProps;
    receiver: UserProps;
    date: Date;
    text: string;
    file: string;
}

export default MessageProps;