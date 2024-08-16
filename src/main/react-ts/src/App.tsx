import './App.css';
import { getUsers } from './api/UserService';
import UserProps from './props/UserProps';
import { User, UserPreview } from './components/user/User';
import { Community } from './components/community/Community';
import React from 'react';
import { getCommunities } from './api/CommunityService';
import CommunityProps from './props/CommunityProps';

const users: UserProps[] = await getUsers();
const communities: CommunityProps[] = await getCommunities();

function App() {
  console.log(users);
  console.log(communities);

  return (
    <div>
      {users.map((user: UserProps) =>
        <div key={user.id}>
          <UserPreview userProps={user}></UserPreview>
        </div>
      )
      }
      {communities.map((community: CommunityProps) => 
        <div key={community.id}>
          <Community props={community}></Community>
        </div>
      )
      }
    </div>
  );
}

export default App;
