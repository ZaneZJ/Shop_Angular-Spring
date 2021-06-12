import { User } from "./user";
import { Text } from "./text";

export interface Chat {
    chatId: number;
    fromUserId: User;
    toUserId: User;
    texts: Text[];
}