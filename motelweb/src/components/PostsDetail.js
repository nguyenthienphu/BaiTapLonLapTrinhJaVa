import { useContext, useEffect, useState } from "react";
import Apis, { authApis, endpoints } from "../configs/Apis";
import { Link, useParams } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
import { Button, Col, Form, Image, ListGroup, Row } from "react-bootstrap";
import { MyUserContext } from "../App";
import Moment from "react-moment";

const PostsDetail = () => {
    const [user,] = useContext(MyUserContext);
    const [comment, setComment] = useState(null);
    const [posts, setposts] = useState(null);
    const [loading, setLoading] = useState(false);
    const [content, setContent] = useState("")
    const { id } = useParams();

    useEffect(() => {
        let loadPosts = async () => {
            let res = await Apis.get(endpoints['posts-detail'](id));
            setposts(res.data);
        }
        let loadComment = async () => {
            let res = await Apis.get(endpoints['comment'](id));
            setComment(res.data);
        }
        loadComment();
        loadPosts();


    }, []);

    const addComment = () => {
        let process = async () => {
            try {
                let res = await authApis().post(endpoints['add-comment'], {
                    "content": content,
                    "posts": posts.id
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
    if (posts === null || comment === null)
        return <MySpinner />;

    return (
        <>
            <h1 className="text-center text-info">CHI TIẾT BÀI VIẾT CỦA TÀI KHOẢN 
                {user !== null ? <> {user.username}</> : ""}
            </h1>
            <Row>
                <Col md={5} xs={6}>
                    <h2 className="text-danger">{posts.name}</h2>
                    <p>Mô tả: {posts.description}</p>
                    <h3>Địa chỉ: {posts.address}</h3>
                </Col>
            </Row>

            <hr />

            {user === null ? <p>Vui lòng <Link to="/login" >đăng nhập</Link> để bình luận! </p> : <>
                {loading ? <MySpinner /> : <>
                    <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
                    <Button onClick={addComment}  className="mt-2" variant="info">Bình luận</Button>
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
    )
}
export default PostsDetail