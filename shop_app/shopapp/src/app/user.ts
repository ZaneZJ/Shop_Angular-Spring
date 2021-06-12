import { EmailValidator } from "@angular/forms";
import { Bank } from "./bank";
import { Service } from "./service";

export interface User {
    user_userId: number;
    user_username: string;
    user_name: string;
    user_surname: string;
    user_phoneNo: string;
    user_address: string;
    user_postalCode: string;
    user_email: string;
    user_pictureMain: string;
    user_accountId: Bank[];
    user_services: Service[];
    user_loyaltyType: string;
    user_status: string;
    user_password: string;
}