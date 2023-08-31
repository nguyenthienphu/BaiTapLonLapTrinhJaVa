import { Alert, Button } from "bootstrap";
import { useState } from "react";
import { Table } from "react-bootstrap";
import cookie from "react-cookies";

const Cart = () => {
    const [cart, setCart] = useState(cookie.load("cart") || null);

    if (cart === null)
        return <Alert variant="info">Không có sản phẩm trong giỏ!</Alert>

    return <>
        <h1 className="text-center text-info">GIỎ HÀNG</h1>
        <Table striped bordered hover>
            <thead>
                <tr>
                    <th>Mã</th>
                    <th>Tên phòng</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {Object.values(cart).map(c => {
                    return <tr key={c.id}>
                        <td>{c.id}</td>
                        <td>{c.name}</td>
                        <td>{c.unitPrice} VNĐ</td>
                        <td>{c.quantity}</td>
                        <td>
                            <Button variant="danger">&times;</Button>
                        </td>
                    </tr>
                })}
            </tbody>
        </Table>
    </>
}
export default Cart