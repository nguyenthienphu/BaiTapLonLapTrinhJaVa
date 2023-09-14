import { useState, useEffect, useContext } from "react"
import Apis, { endpoints } from "../configs/Apis"
import { Alert, Button, Card, Col, Image, Row } from "react-bootstrap"
import { Link, useSearchParams } from "react-router-dom"
import MySpinner from "../layout/MySpinner"
import { MyCartContext, MyUserContext } from "../App"
import cookie from "react-cookies"

const Home = () => {
    const [cartDispatch] = useContext(MyCartContext);
    const [room, setRoom] = useState([])
    const [posts, setPosts] = useState([])
    const [user] = useContext(MyUserContext);

    const [q] = useSearchParams();

    useEffect(() => {
        const loadRoom = async () => {
            try {
                let e = endpoints['room'];

                let hostId = q.get("hostId");
                if (hostId !== null && hostId !== "") {
                    e = `${e}?hId=${hostId}`;
                } else {
                    let kw = q.get("kw");
                    if (kw !== null && kw !== "")
                        e = `${e}?kw=${kw}`;
                }

                let res = await Apis.get(e)
                setRoom(res.data)
            } catch (ex) {
                console.error(ex);
            }
        }

        const loadPosts = async () => {
            let res = await Apis.get(endpoints['posts']);
            setPosts(res.data);
        }

        loadPosts();
        loadRoom();

    }, [q]);

    const order = (r) => {
        cartDispatch({
            "type": "inc",
            "payload": 1
        })
        let cart = cookie.load("cart") || null;
        if (cart === null)
            cart = {}

        if (r.id in cart) {
            cart[r.id]["quantity"] += 1;
        } else {
            cart[r.id] = {
                "id": r.id,
                "name": r.name,
                "unitPrice": r.price,
                "quantity": 1
            }
        }
        cookie.save("cart", cart);
    }

    if (room === null)
        return <MySpinner />

    if (room.length === 0)
        return <Alert variant="info" className="mt-5">Không có phòng nào!</Alert>

    return (
        <>
            <h1 className="text-center text-info">DANH SÁCH PHÒNG CÓ SẴN</h1>
            {user === null ? "" : <>
                {user.userRole === "ROLE_HOST" ? <p><Link to="/addroom" className="btn btn-primary" >Thêm phòng</Link> <Link to="/hostroom/" className="btn btn-primary" >Chi tiết phòng chủ phòng</Link>
                </p>

                    : ""}
            </>}


            <Row>
                {room.map(r => {
                    let url = `/room/${r.id}`
                    return (
                        <Col md={3} xs={12} className="p-2">
                            <Card>
                                <Card.Img variant="top" src={r.image} />
                                <Card.Body>
                                    <Card.Title>Loại phòng: {r.name}</Card.Title>
                                    <Card.Text>Giá: {r.price} VNĐ</Card.Text>
                                    <Card.Text>Mô tả: {r.description}</Card.Text>
                                    <Card.Text>Địa chỉ: {r.address}</Card.Text>
                                    <Link to={url} className="btn btn-primary m-1">Chi tiết phòng</Link>
                                    {user === null ? "" : <>
                                        {user.userRole === "ROLE_USER" ?
                                            <>
                                                <Button variant="danger" onClick={() => order(r)}>Đặt phòng</Button>
                                            </>
                                            : ""}
                                    </>
                                    }
                                </Card.Body>
                            </Card>
                        </Col>
                    )
                })}
            </Row>
            <h1 className="text-center text-info">BÀI VIẾT TÌM PHÒNG THEO YÊU CẦU</h1>
            <Row>
                {posts.map(p => {
                    let url = `/posts/${p.id}`
                    return (
                        <Col md={3} xs={12} className="p-2">
                            <Card>
                                <Card.Body>
                                    <Image src={p.user.avatar} alt={p.user.avatar} width={50} />{p.user.username}
                                    <Card.Title>{p.name}</Card.Title>
                                    <Card.Text>{p.description}</Card.Text>
                                    <Card.Text>{p.address}</Card.Text>
                                    <Link to={url} className="btn btn-primary m-1">Chi tiết</Link>
                                </Card.Body>
                            </Card>
                        </Col>
                    )
                })}
            </Row>





        </>
    )
}
export default Home