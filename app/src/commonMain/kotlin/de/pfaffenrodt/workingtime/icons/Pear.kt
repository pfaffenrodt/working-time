package de.pfaffenrodt.workingtime.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val IconPack.Pear: ImageVector
    get() {
        if (_pear != null) {
            return _pear!!
        }
        _pear = Builder(name = "Pear", defaultWidth = 512.001.dp, defaultHeight = 512.001.dp,
                viewportWidth = 512.001f, viewportHeight = 512.001f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(397.15f, 297.527f)
                curveToRelative(-7.692f, -12.194f, -13.396f, -26.232f, -16.952f, -41.722f)
                curveToRelative(-11.099f, -48.357f, -34.153f, -112.301f, -67.565f, -148.945f)
                curveToRelative(32.585f, -18.074f, 47.995f, -55.31f, 39.73f, -90.036f)
                curveToRelative(-1.535f, -6.45f, -6.4f, -11.587f, -12.757f, -13.471f)
                curveToRelative(-40.87f, -12.105f, -85.122f, 9.421f, -99.751f, 50.812f)
                lineToRelative(-19.732f, -19.732f)
                curveToRelative(-7.232f, -7.233f, -18.959f, -7.233f, -26.193f, 0.0f)
                curveToRelative(-7.233f, 7.233f, -7.233f, 18.959f, 0.0f, 26.193f)
                lineToRelative(27.277f, 27.277f)
                curveToRelative(-46.72f, 29.294f, -77.032f, 113.416f, -89.457f, 167.156f)
                curveToRelative(-3.712f, 16.05f, -9.474f, 30.341f, -17.126f, 42.474f)
                curveToRelative(-57.812f, 91.659f, 35.193f, 214.469f, 141.265f, 214.469f)
                curveToRelative(89.678f, 0.0f, 159.236f, -82.555f, 159.236f, -153.574f)
                curveTo(415.124f, 337.226f, 408.908f, 316.168f, 397.15f, 297.527f)
                close()
                moveTo(317.504f, 37.06f)
                curveToRelative(-0.753f, 23.272f, -19.376f, 42.241f, -42.936f, 42.867f)
                curveToRelative(-0.773f, -0.215f, -1.547f, -0.415f, -2.321f, -0.604f)
                curveTo(273.354f, 55.367f, 293.151f, 36.559f, 317.504f, 37.06f)
                close()
                moveTo(255.887f, 474.958f)
                curveToRelative(-67.284f, 0.0f, -122.194f, -64.096f, -122.194f, -116.531f)
                curveToRelative(0.0f, -37.399f, 21.545f, -40.529f, 34.146f, -95.025f)
                curveToRelative(19.021f, -82.261f, 61.656f, -159.971f, 96.011f, -147.536f)
                curveToRelative(29.204f, 10.544f, 62.951f, 72.881f, 80.245f, 148.225f)
                curveToRelative(12.201f, 53.156f, 33.986f, 56.882f, 33.986f, 94.336f)
                curveTo(378.081f, 410.899f, 323.134f, 474.958f, 255.887f, 474.958f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(218.313f, 405.401f)
                curveToRelative(-11.07f, -8.512f, -20.325f, -20.167f, -25.393f, -31.974f)
                curveToRelative(-4.034f, -9.4f, -14.923f, -13.75f, -24.324f, -9.714f)
                curveToRelative(-9.4f, 4.035f, -13.749f, 14.924f, -9.714f, 24.324f)
                curveToRelative(7.597f, 17.7f, 20.686f, 34.295f, 36.852f, 46.726f)
                curveToRelative(8.11f, 6.238f, 19.739f, 4.715f, 25.972f, -3.392f)
                curveTo(227.94f, 423.266f, 226.422f, 411.637f, 218.313f, 405.401f)
                close()
            }
        }
        .build()
        return _pear!!
    }

private var _pear: ImageVector? = null
