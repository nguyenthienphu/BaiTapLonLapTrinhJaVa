import axios from "axios";
import cookie from "react-cookies";


const SERVER_CONTEXT = "/MotelApp";

export const endpoints = {
    "host": `${SERVER_CONTEXT}/api/host/`,
    "room": `${SERVER_CONTEXT}/api/room/`,
    "login" : `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
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