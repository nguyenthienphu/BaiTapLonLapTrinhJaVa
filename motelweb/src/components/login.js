import { useContext, useState } from "react";
import cookie from "react-cookies";
import Apis, {authApis,endpoints } from "../configs/Apis";
import { Button, Form } from "react-bootstrap";
import { Navigate } from "react-router-dom";
import { MyUserContext } from "../App";

const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const login = (evt) => {
        evt.preventDefault();
        const process = async () => {
            let res = await Apis.post(endpoints['login'], {
                "username": username,
                "password": password
            });
            cookie.save("token", res.data);
            
            let {data} = await authApis().get(endpoints['current-user']);
            cookie.save("user", data);

             dispatch({
                "type": "login",
                "payload": data
            });
        }
        process();
    }
     if (user !== null)
        return <Navigate to="/" />

    return <>
        <h1 className="text-center text-info mt-2">ĐĂNG NHẬP NGƯỜI DÙNG</h1>

        <Form onSubmit={login}>
            <Form.Group className="mb-3" >
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control type="text" value={username} onChange={e => setUsername(e.target.value)} placeholder="Tên đăng nhập" />
            </Form.Group>
            <Form.Group className="mb-3" >
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control type="password" value={password} onChange={e => setPassword(e.target.value)} placeholder="Mật khẩu" />
            </Form.Group>
            <Form.Group className="mb-3">
                <Button type="submit" variant="danger">Đăng nhập</Button>
            </Form.Group>
        </Form>
    </>
}
export default Login