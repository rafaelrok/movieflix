import 'react-toastify/dist/ReactToastify.css';
import 'assets/styles/custom.scss';
import './App.css';

import { ToastContainer } from 'react-toastify';
import Routes from 'Routes';
import { useState } from 'react';
import { AuthContext, AuthContextData } from 'AuthContext';

function App() {
  const [authContextData, setAuthContextData] = useState<AuthContextData>({
    authenticated: false,
  });

  return (
    <AuthContext.Provider value={{ authContextData, setAuthContextData }}>
      <Routes />
      <ToastContainer />
    </AuthContext.Provider>
  );
}

export default App;