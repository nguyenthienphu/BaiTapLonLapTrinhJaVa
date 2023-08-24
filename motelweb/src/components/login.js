import { Form } from "react-bootstrap/lib/Navbar"

const Login = () => {
    return <>
        <h1 className="text-center text-info mt-2">ĐĂNG NHẬP NGƯỜI DÙNG</h1>

        <Form>
            <Form.Group className="mb-3" >
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control type="text" placeholder="Tên đăng nhập" />
            </Form.Group>
            <Form.Group className="mb-3" >
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control type="password" placeholder="Mật khẩu" />
            </Form.Group>
        </Form>
    </>
}
export default Login