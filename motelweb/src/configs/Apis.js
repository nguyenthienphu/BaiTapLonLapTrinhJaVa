import axios from "axios";
const SERVER_CONTEXT = "/MotelApp";

export const endpoints = {
    "host": `${SERVER_CONTEXT}/api/host/`,
    "room": `${SERVER_CONTEXT}/api/room/`,
    "login" : `${SERVER_CONTEXT}/api/login/`,
}

export default axios.create({
    baseURL: "http://localhost:8080"
});