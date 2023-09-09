import { useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import { Card, Col, Row } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";

const HostRoomDetail = () => {
    const [room, setRoom] = useState([])
    const [q] = useSearchParams();

    useEffect(() => {
        const loadRoom = async () => {
            let e = endpoints['room'];

            let hostId = q.get("hostId");
            if (hostId !== null && hostId !== "") {
                e = `${e}?hId=${hostId}`;
            }

            let res = await Apis.get(e)
            setRoom(res.data)
        }
        loadRoom();
        } ,[q]);
    return(
        <>
            <h1 className="text-center text-info">CÁC PHÒNG CỦA CHỦ PHÒNG</h1>
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
                                </Card.Body>
                            </Card>
                        </Col>
                    )
                })}
            </Row>
        </>
    )
}
export default HostRoomDetail
