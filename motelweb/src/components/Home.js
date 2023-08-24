import { useState, useEffect } from "react"
import Apis, { endpoints } from "../configs/Apis"
import { Alert, Button, Card, Col, Row } from "react-bootstrap"
import { Link, useSearchParams } from "react-router-dom"
import MySpinner from "../layout/MySpinner"

const Home = () => {
    const [room, setRoom] = useState([])
    const [q] = useSearchParams();

    useEffect(() => {
        const loadRoom = async () => {
            try {
                let e = endpoints['room'];

                let hostId = q.get("hostId");
                if (hostId !== null && hostId !== "") {
                    e = `${e}?hostId=${hostId}`;
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
        loadRoom();

    }, [q]);

    if (room === null)
        return <MySpinner />

    if (room.length === 0)
        return <Alert variant="info" className="mt-5">Không có phòng nào!</Alert>

    return (
        <>
            <h1 className="text-center text-info">DANH SÁCH PHÒNG</h1>
            <Row>
                {room.map(r => {
                    let url = `/room/${r.id}`
                    return (
                        <Col md={3} xs={12} className="p-2">
                            <Card>
                                <Card.Img variant="top" src={r.image} />
                                <Card.Body>
                                    <Card.Title>{r.name}</Card.Title>
                                    <Card.Text>{r.price} VNĐ</Card.Text>
                                    <Card.Text>{r.description}</Card.Text>
                                    <Card.Text>{r.address}</Card.Text>
                                    <Link to={url} className="btn btn-primary">Chi tiết phòng</Link>
                                    <Button variant="danger">Đặt hàng</Button>
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