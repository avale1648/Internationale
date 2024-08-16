import './App.css';
import { getUsers } from './api/UserService';
import {UserProps} from './props/UserProps';
import { User } from './components/user/User';
import React from 'react';

const users: UserProps[] = await getUsers();

function App() {
  console.log(users);
 
  return (
    <div>
      { users.map( (user: UserProps) => 
        <div key = {user.name}>
          <User userProps={user}></User>
        </div>
      )
      }
    </div>
  );
}

export default App;
