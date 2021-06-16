import { User } from "./user";

export interface Review {
    reviewId: number;
    rated: number;
    reviewText: string;
    userReviewFrom: string;
    userReviewTo: string;
}