import { useContext } from "react";
import { MyUserContext } from "../App";

const AddRoom = () => {
    const [user] = useContext(MyUserContext);
    return(
        <>
            <h1 className="text-center text-info">THÊM PHÒNG CỦA CHỦ PHÒNG {user.lastName} {user.firstName}</h1>
        </>
    )
}
export default AddRoom