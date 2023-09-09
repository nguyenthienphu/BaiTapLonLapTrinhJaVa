import axios from "axios";
import cookie from "react-cookies";


const SERVER_CONTEXT = "/MotelApp";

export const endpoints = {
    "host": `${SERVER_CONTEXT}/api/host/`,
    "room": `${SERVER_CONTEXT}/api/room/`,
    "room-detail": (roomId) => `${SERVER_CONTEXT}/api/room/${roomId}/`,
    "login" : `${SERVER_CONTEXT}/api/login/`,
    "register": `${SERVER_CONTEXT}/api/users/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "comment": (roomId) => `${SERVER_CONTEXT}/api/room/${roomId}/comment/`,
    "add-comment": `${SERVER_CONTEXT}/api/comment/`,
    "posts": `${SERVER_CONTEXT}/api/posts/`,
}
export const authApis = () => {
    return axios.create({
        baseURL: "http://localhost:8080",
        headers: {
            "Authorization": cookie.load("token")
        }
    });
}

export default axios.create({
    baseURL: "http://localhost:8080"
});