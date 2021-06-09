export interface User {
    userId: number;
    username: string;
    name: string;
    surname: string;
    phoneNo: string;
    address: string;
    postalCode: string;
    pictureMain: string;
    accountId: number;
    // FIXME: returns Set of strings
    services: number;
    type: string;
}