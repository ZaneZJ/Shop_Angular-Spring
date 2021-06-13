import { EmailValidator } from "@angular/forms";
import { Bank } from "./bank";
import { Service } from "./service";

export interface User {
    userId: number;
    username: string;
    name: string;
    surname: string;
    phoneNo: string;
    address: string;
    postalCode: string;
    email: string;
    pictureMain: string;
    bank: Bank[];
    services: Service[];
    loyaltyType: string;
    status: string;
    role: string;
    password: string;
}