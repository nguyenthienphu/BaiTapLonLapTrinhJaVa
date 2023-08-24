import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import { Container } from 'react-bootstrap';
import Room from './components/Room';

function App() {
  return (
    <BrowserRouter>
      <Header />

      <Container>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/room" element={<Room />} />
        </Routes>

      </Container>

      <Footer/>
    </BrowserRouter>
  );
}

export default App;
