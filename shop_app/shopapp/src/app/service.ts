import { Chat } from "./chat";
import { Instance } from "./instance";
import { Pictures } from "./pictures";
import { Review } from "./review";
import { User } from "./user";

export interface Service {
    serviceId: number;
    instances: Instance[];
    title: string;
    description: number;
    theme: string;
    reviews: Review[];
    chats: Chat[];
    username: User;
    pictures: Pictures[];
}