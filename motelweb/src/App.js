import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import { Container } from 'react-bootstrap';
import Login from './components/Login';
import Cart from './components/Cart';
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import MyCartCounterReducer from './reducers/MyCartCounterReducer';
import RoomDetail from './components/RoomDetail';
import 'moment/locale/vi';
import moment from 'moment'
import Register from './components/Register';
import AddPosts from './components/AddPosts';
import AddRoom from './components/AddRoom';
import HostRoomDetail from './components/HostRoomDetail';
import PostsDetail from './components/PostsDetail';

moment().local("vi")

export const MyUserContext = createContext();
export const MyCartContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  const [cartCounter, cartDispatch] = useReducer(MyCartCounterReducer, 0  );

  return (
    <MyUserContext.Provider value={[user, dispatch]}>
      <MyCartContext.Provider value={[cartCounter, cartDispatch]}>
        <BrowserRouter>
          <Header />

          <Container>

            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/room/:roomId" element={<RoomDetail />} />
              <Route path="/addroom" element={<AddRoom />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/cart" element={<Cart />} />
              <Route path="/addposts" element={<AddPosts />} />
              <Route path="/hostroom/" element={<HostRoomDetail />} />
              <Route path="/posts/:id" element={<PostsDetail />} />
            </Routes>

          </Container>

          <Footer />
        </BrowserRouter>
      </MyCartContext.Provider>
    </MyUserContext.Provider >
  );
}

export default App;
