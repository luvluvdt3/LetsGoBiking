import i0 from '../assets/types/0_left.png'
import i1 from '../assets/types/1_right.png'
import i2 from '../assets/types/2_sharpLeft.png'
import i3 from '../assets/types/3_sharpRight.png'
import i4 from '../assets/types/4_slightLeft.png'
import i5 from '../assets/types/5_slightRight.png'
import i6 from '../assets/types/6_straight.png'
import i7 from '../assets/types/7_enterRoundabout.png'
import i8 from '../assets/types/8_exitRoundabout.png'
import i9 from '../assets/types/9_uturn.png'
import i10 from '../assets/types/10_goal.png'
import i11 from '../assets/types/11_depart.png'
import i12 from '../assets/types/12_keepLeft.png'
import i13 from '../assets/types/13_keepRight.png'
import i14 from '../assets/types/14_unknown.png'
import bike from '../assets/types/bike.png'
import walk from '../assets/types/walk.png'
export default function GetTypeIcon(props) {
    const { type } = props;

    const getIcon = () =>{
        switch(type){
            case 0:
                return i0;
            case 1:
                return i1;
            case 2:
                return i2;
            case 3:
                return i3;
            case 4:
                return i4;
            case 5:
                return i5;
            case 6:
                return i6;
            case 7:
                return i7;
            case 8:
                return i8;
            case 9:
                return i9;
            case 10:
                return i10;
            case 11:
                return i11;
            case 12:
                return i12;
            case 13:
                return i13;
            case 14:
                return i14;
                case 15:
                return walk;
                case 16:
                return bike;
                case 17:
                    return walk;
            default:
                return i14;
        }
    }

    return(
        <img
                    src={getIcon()}
                    alt="Intruction Icon"
                    className="h-8 w-8"
                  />
    )

}