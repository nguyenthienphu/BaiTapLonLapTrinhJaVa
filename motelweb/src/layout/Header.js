import { useState, useEffect, useContext } from "react"
import Apis, { endpoints } from "../configs/Apis"
import { Button, Container, Form, Nav, NavDropdown, Navbar, Badge } from "react-bootstrap"
import { Link, useNavigate } from "react-router-dom"
import MySpinner from "./MySpinner"
import { MyCartContext, MyUserContext } from "../App"

const Header = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [cartCounter,] = useContext(MyCartContext);
    const [host, setHost] = useState([])
    const [kw, setKw] = useState("");
    const nav = useNavigate();

    useEffect(() => {
        const loadHost = async () => {
            let res = await Apis.get(endpoints['host'])
            setHost(res.data)
        }
        loadHost();

    }, [])

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`);

    }

    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }

    if (host === null)
        return <MySpinner />;

    return (
        <Container>
            <Navbar bg="light" data-bs-theme="light">
                <Nav className="me-auto">
                    <Navbar.Brand href="/">Trang chủ</Navbar.Brand>
                    <NavDropdown title="Danh mục chủ phòng" id="basic-nav-dropdown">
                        {host.map(h => {
                            let q = `/?hostId=${h.id}`;
                            return <Link to={q} className="dropdown-item" key={h.id}>{h.name}</Link>;
                        })}
                    </NavDropdown>
                    {user === null ? <> <Link to="/login" className="nav-link text-danger">Đăng nhập</Link>
                        <Link className="nav-link text-danger" to="/register">Đăng ký</Link>
                    </>
                        : <>
                            <Link to="/login" className="nav-link text-succes">Chào {user.lastName} {user.firstName} </Link>                    
                            <Button variant="secondary" onClick={logout}>Đăng xuất</Button>
                            <Link className="nav-link text-primary" to="/addposts">Đăng tin tìm phòng</Link>
                            <Link className="nav-link text-primary" to="/hostroom/" >{user.hostId.name}</Link>
                        </>
                    }
                    <Link to="/cart" className="nav-link text-danger">Giỏ hàng <Badge> {cartCounter} </Badge></Link>
                </Nav>
                <Form className="d-flex" onSubmit={search}>
                    <Form.Control
                        type="search"
                        placeholder="Tìm kiếm..."
                        className="me-2"
                        aria-label="Search"
                        value={kw}
                        onChange={e => setKw(e.target.value)}
                    />
                    <Button type="submit" variant="outline-success">Tìm</Button>
                </Form>
            </Navbar>
        </Container>
    )
}
export default Header