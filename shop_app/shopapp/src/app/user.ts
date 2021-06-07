export interface User {
    userId: number;
    username: string;
    name: string;
    surname: string;
    phoneNo: string;
    address: string;
    postalCode: string;
    pictureMain: string;
    // FIXME: returns Set of strings
    accountNo: string;
    services: string;
    type: string;
}