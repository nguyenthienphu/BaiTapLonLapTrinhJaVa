import { useContext, useEffect, useState } from "react"
import { Button, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import { Link, useParams } from "react-router-dom";
import Apis, { authApis, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import { MyUserContext } from "../App";
import Moment from "react-moment";

const RoomDetail = () => {
    const [user,] = useContext(MyUserContext);
    const [room, setRoom] = useState(null)
    const [comment, setComment] = useState(null);
    const { roomId } = useParams();
    const [loading, setLoading] = useState(false)
    const [content, setContent] = useState("")

    useEffect(() => {
        let loadRoom = async () => {
            let res = await Apis.get(endpoints['room-detail'](roomId));
            setRoom(res.data);
        }

        let loadComment = async () => {
            let res = await Apis.get(endpoints['comment'](roomId));
            setComment(res.data);
        }

        loadRoom();
        loadComment();

    }, []);

    const addComment = () => {
        let process = async () => {
            try {
                let res = await authApis().post(endpoints['add-comment'], {
                    "content": content,
                    "room": room.id
                });

                setComment([...comment, res.data]);

            } catch (ex) {

            } finally {
                setLoading(false)
            }
        }
        setLoading(true)
        process();
    }


    if (room === null || comment === null)
        return <MySpinner />;
    return <>
        <h1 className="text-center text-info">CHI TIẾT PHÒNG</h1>
        <Row>
            <Col md={5} xs={6}>
                <Image src={room.image} rounded fluid />
            </Col>
            <Col md={5} xs={6}>
                <h2 className="text-danger">{room.name}</h2>
                <p>{room.description}</p>
                <h3>{room.price} VNĐ</h3>
            </Col>
        </Row>

        <hr />

        {user === null ? <p>Vui lòng <Link to="/login" >đăng nhập</Link> để bình luận! </p> : <>
            {loading ? <MySpinner /> : <>
                <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
                <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>
            </>}
        </>}

        <hr />
        <ListGroup>
            {comment.map(c => <ListGroup.Item id={c.id}>
                <Row className="bg-light m-1 p-1">
                    <Col xs={3} md={1}>
                        <Image src={c.user.avatar} alt={c.user.avatar} rounded fluid />
                    </Col>
                    <Col xs={9} md={11}>
                        <p>{c.content}</p>
                        <small>Được bình luận bởi {c.user.username} vào <Moment fromNow>{c.createdDate}</Moment> </small>
                    </Col>
                </Row>
            </ListGroup.Item>)
            }
        </ListGroup>
    </>
}
export default RoomDetail